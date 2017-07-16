
package org.smslib.hook;

import org.smslib.gateway.AbstractGateway;
import org.smslib.message.OutboundMessage;

import java.util.Collection;

public interface IRouteHook
{
	public Collection<AbstractGateway> process(OutboundMessage message, Collection<AbstractGateway> gateways);
}
