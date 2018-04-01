package demo.sso.json;

import java.util.HashMap;
import java.util.HashSet;

public abstract class JsonPropertyFilter implements
        net.sf.json.util.PropertyFilter {
    HashMap<String, Object> filterObjectMap = new HashMap<String, Object>();
    HashSet<Object> filterObjectSet = new HashSet<Object>();

    public abstract boolean apply(Object arg0, String arg1, Object arg2);

}