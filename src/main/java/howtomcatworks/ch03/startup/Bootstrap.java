package howtomcatworks.ch03.startup;

import howtomcatworks.ch03.connector.http.HttpConnector;

public final class Bootstrap {
  public static void main(String[] args) {
    HttpConnector connector = new HttpConnector();
    connector.start();
  }
}