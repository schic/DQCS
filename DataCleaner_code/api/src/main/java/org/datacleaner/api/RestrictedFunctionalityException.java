/**
 * DataCleaner (community edition)
 * Copyright (C) 2014 Free Software Foundation, Inc.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
package org.datacleaner.api;

/**
 * An exception that {@link Component}s can throw when certain functionality is
 * restricted - typically because it's a paid for function or because an
 * approval process is pending or so.
 * 当某些功能受到限制时，{@link Component}可能引发的异常-通常是因为它是付费功能，
 * 或者因为批准程序正在等待中。
 *
 * Typically the user interface will have special handling available for this
 * exception type to guide him in the direction of unlocking the restricted
 * functionality.
 * 通常，用户界面将对此异常类型提供特殊处理，以指导他朝着解锁受限功能的方向发展。
 *
 * This class and {@link RestrictedFunctionalityMessage} are two ways to
 * archieve something quite similar. The main difference is that a
 * {@link RestrictedFunctionalityMessage} can be used in scenarios where a job
 * is allowed to finish with just a partially functional result (for instance a
 * transformer may change it's behaviour after the message is sent) whereas the
 * {@link RestrictedFunctionalityException} will cancel the job because the
 * functionality is simply unavailable or a partial result is not granted
 * either.
 * 此类和{@link RestrictedFunctionalityMessage}是将相似的内容存档的两种方法。
 * 主要区别在于，
 * {@link RestrictedFunctionalityMessage}可以用于允许仅以部分功能性结果完成某项工作的情况
 * （例如，在发送消息后，转换器可以更改其行为），
 * 而{@link RestrictedFunctionalityException}将取消作业，因为*功能根本不可用或未授予部分结果。
 */
public class RestrictedFunctionalityException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private final RestrictedFunctionalityCallToAction[] _callToActions;

    /**
     * Constructs a {@link RestrictedFunctionalityException}
     *
     * @param message
     *            a message to the user about what and why he is being
     *            restricted in functionality.
     * @param callToActions
     *            an array of call to actions for the user to pick from.
     */
    public RestrictedFunctionalityException(final String message,
            final RestrictedFunctionalityCallToAction... callToActions) {
        super(message, null, true, false);
        _callToActions = callToActions;
    }

    /**
     * Constructs a {@link RestrictedFunctionalityException}
     *
     * @param message
     *            a message to the user about what and why he is being
     *            restricted in functionality.
     * @param cause
     *            an underlying cause of the restriction
     * @param callToActions
     *            an array of call to actions for the user to pick from.
     */
    public RestrictedFunctionalityException(final String message, final Throwable cause,
            final RestrictedFunctionalityCallToAction... callToActions) {
        super(message, cause, true, false);
        _callToActions = callToActions;
    }

    public RestrictedFunctionalityCallToAction[] getCallToActions() {
        return _callToActions;
    }
}
