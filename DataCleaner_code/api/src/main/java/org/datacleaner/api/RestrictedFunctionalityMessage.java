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
 * {@link ComponentMessage} that can be published (via {@link ComponentContext}
 * by components if certain functionality is restricted - typically because it's
 * a paid for function or because an approval process is pending or so.
 * 如果某些功能受到限制，则可以由组件发布{@link ComponentMessage}
 * （通过{@link ComponentContext}）-通常是因为它是功能付费或批准程序正在等待中。
 *
 * Typically the user interface will have special handling available for this
 * message type to guide him in the direction of unlocking the restricted
 * functionality.
 * 通常，用户界面将对此消息类型提供特殊处理，以指导他朝着解锁受限功能的方向发展。
 *
 * Publishing the message once per job should be sufficient. Dispatching of more
 * than one such message may be disregarded by the user interface.
 * 每个作业发布一次消息就足够了。用户界面可以忽略调度多于一个这样的消息。
 *
 * This class and {@link RestrictedFunctionalityException} are two ways to
 * archieve something quite similar. The main difference is that a
 * {@link RestrictedFunctionalityMessage} can be used in scenarios where a job
 * is allowed to finish with just a partially functional result (for instance a
 * transformer may change it's behaviour after the message is sent) whereas the
 * {@link RestrictedFunctionalityException} will cancel the job because the
 * functionality is simply unavailable or a partial result is not granted
 * either.
 * 此类和{@link RestrictedFunctionalityException}是归档非常相似的东西的两种方法。
 * 主要区别在于，
 * {@link RestrictedFunctionalityMessage}可以用于允许仅以部分功能性结果完成某项工作的情况
 * （例如，在发送消息后，转换器可以更改其行为），
 * 而{@link RestrictedFunctionalityException}将取消作业，因为功能根本不可用或未授予部分结果。
 */
public class RestrictedFunctionalityMessage implements ComponentMessage {

    private final String _message;
    private final RestrictedFunctionalityCallToAction[] _callToActions;

    /**
     * Constructs a {@link RestrictedFunctionalityMessage}
     *
     * @param message
     *            a message to the user about what and why he is being
     *            restricted in functionality.
     * @param callToActions
     *            an array of call to actions for the user to pick from.
     */
    public RestrictedFunctionalityMessage(final String message,
            final RestrictedFunctionalityCallToAction... callToActions) {
        _message = message;
        _callToActions = callToActions;
    }

    public String getMessage() {
        return _message;
    }

    public RestrictedFunctionalityCallToAction[] getCallToActions() {
        return _callToActions;
    }
}
