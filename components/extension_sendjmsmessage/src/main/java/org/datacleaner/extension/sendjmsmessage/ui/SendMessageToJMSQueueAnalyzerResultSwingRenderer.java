package org.datacleaner.extension.sendjmsmessage.ui;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.util.Collection;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;

import org.apache.metamodel.util.FileHelper;
import org.datacleaner.api.RendererBean;
import org.datacleaner.extension.sendjmsmessage.SendMessageToJMSQueueAnalyzerResult;
import org.datacleaner.extension.sendjmsmessage.SendMessageToJMSQueueResult;
import org.datacleaner.panels.DCPanel;
import org.datacleaner.result.renderer.AbstractRenderer;
import org.datacleaner.result.renderer.SwingRenderingFormat;
import org.datacleaner.util.FileFilters;
import org.datacleaner.util.IconUtils;
import org.datacleaner.util.ImageManager;
import org.datacleaner.util.WidgetUtils;
import org.datacleaner.widgets.Alignment;
import org.datacleaner.widgets.DCFileChooser;
import org.jdesktop.swingx.VerticalLayout;

/**
 * Result render for Send Message to JMS.
 *
 */
@RendererBean(SwingRenderingFormat.class)
public class SendMessageToJMSQueueAnalyzerResultSwingRenderer extends AbstractRenderer<SendMessageToJMSQueueAnalyzerResult, JComponent> {

    /**
     * {@inheritDoc}
     */
    @Override
    public JComponent render(SendMessageToJMSQueueAnalyzerResult analyzerResult) {
        final int successCount = analyzerResult.getSuccessCount();
        final int skipCount = analyzerResult.getSkipCount();
        final int failureCount = analyzerResult.getFailureCount();
        final DCPanel panel = new DCPanel();
        panel.setLayout(new VerticalLayout(4));
        panel.add(createMetricText("Messages sent: ", successCount));
        panel.add(createMetricText("Messages skipped: ", skipCount));
        panel.add(createMetricText("Messages failed: ", failureCount));

        final Collection<SendMessageToJMSQueueResult> failures = analyzerResult.getFailures();

        if (!failures.isEmpty()) {
            final Icon icon = ImageManager.get().getImageIcon(IconUtils.CSV_IMAGEPATH, IconUtils.ICON_SIZE_MEDIUM);
            final JButton exportButton = new JButton("Export failure recipients", icon);
            exportButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    final DCFileChooser fileChooser = new DCFileChooser();
                    fileChooser.addChoosableFileFilter(FileFilters.TXT);
                    final int result = fileChooser.showSaveDialog(panel);
                    if (result == DCFileChooser.APPROVE_OPTION) {
                        final File selectedFile = fileChooser.getSelectedFile();
                        final BufferedWriter writer = FileHelper.getBufferedWriter(selectedFile);
                        try {
                            writer.write("recipient");
                            for (SendMessageToJMSQueueResult sendMessage : failures) {
                                writer.write('\n' + sendMessage.getMessageIdentifier());
                            }
                        } catch (Exception ex) {
                            WidgetUtils.showErrorMessage("Failed to export failure recipients", ex);
                        } finally {
                            FileHelper.safeClose(writer);
                        }
                    }
                }
            });

            final DCPanel exportButtonPanel = new DCPanel();
            exportButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
            exportButtonPanel.add(exportButton);
            panel.add(exportButtonPanel);
        }

        int failuresPresented = 0;
        for (SendMessageToJMSQueueResult failureSendMessageResult : failures) {
            panel.add(createFailureText(failureSendMessageResult));
            failuresPresented++;
            if (failuresPresented > 20) {
                // prevent too many errors on page
                break;
            }
        }
        return panel;
    }

    private Component createFailureText(SendMessageToJMSQueueResult failureSendMessageResult) {
        final JLabel recipientLabel = new JLabel(failureSendMessageResult.getMessageIdentifier());
        recipientLabel.setFont(WidgetUtils.FONT_NORMAL.deriveFont(Font.BOLD));

        DCPanel panel = new DCPanel(WidgetUtils.BG_COLOR_BRIGHTEST);
        panel.setLayout(new FlowLayout(Alignment.LEFT.getFlowLayoutAlignment()));
        panel.add(new JLabel("Failed to send message to: "));
        panel.add(recipientLabel);

        final Exception error = failureSendMessageResult.getError();
        if (error != null) {
            String message = error.getMessage();
            panel.add(new JLabel("Error message (see log for details): " + message));
        }

        return WidgetUtils.decorateWithShadow(panel, false, 2);
    }

    private Component createMetricText(String metric, int value) {
        final JLabel valueLabel = new JLabel("" + value);
        valueLabel.setFont(WidgetUtils.FONT_NORMAL.deriveFont(Font.BOLD));

        DCPanel panel = new DCPanel(WidgetUtils.BG_COLOR_BRIGHTEST);
        panel.setLayout(new FlowLayout(Alignment.LEFT.getFlowLayoutAlignment()));
        panel.add(new JLabel(metric));
        panel.add(valueLabel);
        return WidgetUtils.decorateWithShadow(panel, false, 2);
    }

}
