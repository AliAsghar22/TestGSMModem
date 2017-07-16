
package org.smslib.routing;

import org.smslib.gateway.AbstractGateway;
import org.smslib.message.OutboundMessage;

import java.util.Collection;

public abstract class AbstractBalancer
{
	public abstract Collection<AbstractGateway> balance(OutboundMessage message, Collection<AbstractGateway> candidates);
}
