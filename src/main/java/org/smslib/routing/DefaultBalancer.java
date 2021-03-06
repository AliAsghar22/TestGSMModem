
package org.smslib.routing;

import org.smslib.gateway.AbstractGateway;
import org.smslib.helper.GatewayOutboundTrafficComparator;
import org.smslib.message.OutboundMessage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DefaultBalancer extends AbstractBalancer
{
	@Override
	public Collection<AbstractGateway> balance(OutboundMessage message, Collection<AbstractGateway> candidates)
	{
		ArrayList<AbstractGateway> gatewayList = new ArrayList<>(candidates);
		GatewayOutboundTrafficComparator comp = new GatewayOutboundTrafficComparator();
		Collections.sort(gatewayList, comp);
		return gatewayList;
	}
}
