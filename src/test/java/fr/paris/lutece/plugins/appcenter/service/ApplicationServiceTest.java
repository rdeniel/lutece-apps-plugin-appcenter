/*
 * Copyright (c) 2002-2017, Mairie de Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */

package fr.paris.lutece.plugins.appcenter.service;

import fr.paris.lutece.plugins.appcenter.business.Application;
import fr.paris.lutece.plugins.appcenter.modules.sources.business.SourcesData;
import java.io.IOException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * ApplicationService Test
 */
public class ApplicationServiceTest
{
    private static final String SITE_DIRECTORY = "http://dev.lutece.paris.fr/svn/lutece/portal/trunk/plugins/cms/plugin-stock/";
    private static final String PLUGIN_DIRECTORY = "http://dev.lutece.paris.fr/svn/lutece/portal/trunk/plugins/cms/plugin-rating/";
    private static final String JSON = "{\"sources\":{\"siteRepository\":\"http://dev.lutece.paris.fr/svn/lutece/portal/trunk/plugins/cms/plugin-stock/\",\"pluginRepositories\":[\"http://dev.lutece.paris.fr/svn/lutece/portal/trunk/plugins/cms/plugin-rating/\"]}}\n";

    /**
     * Test of getApplicationData method, of class ApplicationService.
     * 
     * @throws java.io.IOException
     */
    @Test
    public void testGetApplicationData( ) throws IOException
    {
        System.out.println( "getApplicationData" );
        Application application = new Application( );
        SourcesData data = new SourcesData( );
        data.setSiteRepository( SITE_DIRECTORY );
        data.addPluginRepository( PLUGIN_DIRECTORY );
        String strGlobalJson = ApplicationService.getApplicationData( application, data );
        System.out.println( strGlobalJson );
    }

    /**
     * Test of getDataSubset method, of class ApplicationService.
     * 
     * @throws java.io.IOException
     */
    @Test
    public void testGetDataSubset( ) throws IOException
    {
        System.out.println( "getDataSubset" );
        SourcesData data = ApplicationService.getDataSubset( JSON, SourcesData.DATA_SUBSET_NAME, SourcesData.class );

        assertEquals( data.getSiteRepository( ), SITE_DIRECTORY );
        assertEquals( data.getPluginRepositories( ).get( 0 ), PLUGIN_DIRECTORY );
    }

}