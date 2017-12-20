import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import javax.management.Attribute;
import javax.management.MBeanServerConnection;
import javax.management.MBeanInfo;
import javax.management.MBeanServerInvocationHandler;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

public class Client {
	public static void main(String[] args) {
		try {
			String serverUrl = args[0];
			String domainmbean = args[1];
			String mbeanquery = args[2];
			String mbeansubquery = "";
			if (args.length == 4) {
				mbeansubquery = args[3];
			}
			//if (args[3] != null && !args[3].isEmpty()){
			//	mbeansubquery = args[3];
			//}

			JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://"+serverUrl+"/jmxrmi");
			JMXConnector jmxc = JMXConnectorFactory.connect(url, null);
			MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();

			//ObjectName mbean = new ObjectName("java.lang:name=Par Eden Space,type=MemoryPool");
			ObjectName mbean = new ObjectName(domainmbean);

			//System.out.println(mbeansubquery);

			//\String mbeanvalue = mbsc.getAttribute(mbean, mbeansubquery).toString();
			//\System.out.println(mbeanvalue);

			Object mbeanvalue = mbsc.getAttribute(mbean, mbeanquery);
			if ( mbeanvalue instanceof javax.management.openmbean.CompositeDataSupport ) {
				if ( args.length == 4 ) {
					mbeanvalue = ((javax.management.openmbean.CompositeDataSupport)mbeanvalue).get(mbeansubquery);
				} else if ( args.length == 3 ) {
					mbeanvalue = ((javax.management.openmbean.CompositeDataSupport)mbeanvalue).get(mbeanquery);
				}
			}
			System.out.println(mbeanvalue);
			
			//Object result = mbsc.getAttribute( mbean, "Used");

			//String mbean = mbsc.getAttribute(mbean, "Usage").toString();
			//String mbeanvalue = mbsc.getAttribute(mbean, "Usage").toString();
			//result = ((javax.management.openmbean.CompositeDataSupport)result).get("Usage.max");
			//MBeanServerConnection con = jmxc.getConnection().getServerConnection();
			//System.out.println(result.toString());


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
