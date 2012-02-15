/**
 * Copyright (c) {2003,2009} {openmobster@gmail.com} {individual contributors as indicated by the @authors tag}.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.openmobster.core.dataService.processor;

import org.apache.log4j.Logger;


import org.openmobster.core.synchronizer.model.SyncAdapterRequest;
import org.openmobster.core.synchronizer.model.SyncAdapterResponse;
import org.openmobster.core.synchronizer.server.SyncServer;

/**
 * 
 * @author openmobster@gmail.com
 */
public class SyncProcessor implements Processor 
{
	private static Logger log = Logger.getLogger(SyncProcessor.class);
			
	/**
	 * Unique processor id to route mobile traffic to
	 */
	private String id;
	
	/**
	 * Adapter for the synchronization engine
	 */
	private SyncServer syncAdapter;
		
	public SyncProcessor()
	{
		
	}
		
	public SyncServer getSyncAdapter()
	{
		return syncAdapter;
	}

	
	public void setSyncAdapter(SyncServer syncAdapter)
	{
		this.syncAdapter = syncAdapter;
	}
			
	public void setId(String id)
	{
		this.id = id;
	}
	
	public void start()
	{		
						
	}
		
	public void stop()
	{
		
	}	
	//------------------------------------------------------------------------------------------------------------------	
	public String getId() 
	{
		return this.id;
	}
	
	public String process(Input input) throws ProcessorException 
	{	
		try
		{
			//Using the serverside sync
			String payload = input.getMessage().trim();
			log.info("Received------------------------------------------------------------------------");
			log.info(payload);
			
			SyncAdapterRequest serverRequest = new SyncAdapterRequest();
			serverRequest.setAttribute(SyncServer.PAYLOAD, payload);
			SyncAdapterResponse serverResponse = this.syncAdapter.service(serverRequest);
	
			// Setup request to be sent to the Client Syncher
			// based on payload received from the server
			payload = (String) serverResponse
			.getAttribute(SyncServer.PAYLOAD);	
			
			log.info("Sending------------------------------------------------------------------------");
			log.info(payload);
			
			return payload;
		}
		catch(Exception e)
		{
			log.error(this, e);
			throw new ProcessorException(e);
		}
	}	
}