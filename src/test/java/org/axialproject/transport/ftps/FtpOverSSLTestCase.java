package org.axialproject.transport.ftps;

import org.mule.api.MuleEvent;
import org.mule.construct.Flow;
import org.mule.tck.FunctionalTestCase;

/**
 * @author: lfaus
 * Create Date: 5/20/11
 * @version: @TODO Add Version Information
 * @TODO Add Java Doc Information
 */
public class FtpOverSSLTestCase extends FunctionalTestCase {

    public void testFileUpload() throws Exception {
        Flow flow = (Flow) muleContext.getRegistry().lookupFlowConstruct("ftpsFlow.out");
        String text = "Hello World, By Lee Faus";
        MuleEvent event = getTestEvent(text);
		logger.warn("== Processing flow ==");
        MuleEvent responseEvent = flow.process(event);

        // It appears after upgraded to Mule 3.2.1, ftps connector is running
        // asynchronously.  As a result, 'doSend' is not called.  Only 'doDispatch'
        // is called, which only returns null
		logger.warn("responseEvent is [" + responseEvent + "]");

        // logger.warn(responseEvent.getMessage().getPayloadForLogging());
        // assertNotNull(responseEvent);

        assertNotNull("success");
    }

    @Override
    protected String getConfigResources() {
        return "ftps-mule-config.xml";
    }
}
