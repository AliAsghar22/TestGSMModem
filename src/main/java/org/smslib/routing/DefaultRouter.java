
package org.smslib.routing;

import org.smslib.gateway.AbstractGateway;
import org.smslib.message.OutboundMessage;

import java.util.Collection;

public class DefaultRouter extends AbstractRouter
{
	@Override
	public Collection<AbstractGateway> customRoute(OutboundMessage message, Collection<AbstractGateway> gateways)
	{
		return gateways;
	}
}
