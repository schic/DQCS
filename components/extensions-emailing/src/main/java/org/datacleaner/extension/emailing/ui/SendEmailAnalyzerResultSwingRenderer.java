package org.datacleaner.extension.emailing.ui;

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
import org.datacleaner.extension.emailing.EmailResult;
import org.datacleaner.extension.emailing.SendEmailAnalyzerResult;
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

@RendererBean(SwingRenderingFormat.class)
public class SendEmailAnalyzerResultSwingRenderer extends AbstractRenderer<SendEmailAnalyzerResult, JComponent> {

    @Override
    public JComponent render(SendEmailAnalyzerResult analyzerResult) {
        final int successCount = analyzerResult.getSuccessCount();
        final int skipCount = analyzerResult.getSkipCount();
        final int failureCount = analyzerResult.getFailureCount();

        final DCPanel panel = new DCPanel();
        panel.setLayout(new VerticalLayout(4));

        panel.add(createMetricText("Emails sent: ", successCount));
        panel.add(createMetricText("Emails skipped: ", skipCount));
        panel.add(createMetricText("Emails failed: ", failureCount));

        final Collection<EmailResult> failures = analyzerResult.getFailures();

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
                            for (EmailResult emailResult : failures) {
                                writer.write('\n');
                                writer.write(emailResult.getRecipient());
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
        for (EmailResult failureEmailResult : failures) {
            panel.add(createFailureText(failureEmailResult));
            failuresPresented++;
            if (failuresPresented > 20) {
                // prevent too many errors on page
                break;
            }
        }

        return panel;
    }

    private Component createFailureText(EmailResult failureEmailResult) {
        final JLabel recipientLabel = new JLabel(failureEmailResult.getRecipient());
        recipientLabel.setFont(WidgetUtils.FONT_NORMAL.deriveFont(Font.BOLD));

        DCPanel panel = new DCPanel(WidgetUtils.BG_COLOR_BRIGHTEST);
        panel.setLayout(new FlowLayout(Alignment.LEFT.getFlowLayoutAlignment()));
        panel.add(new JLabel("Failed to send email to: "));
        panel.add(recipientLabel);

        final Exception error = failureEmailResult.getError();
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
