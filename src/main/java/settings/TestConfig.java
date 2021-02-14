package settings;

import org.aeonbits.owner.Config;

public interface TestConfig extends Config {
    String baseUrl();
    String email();
    String password();
    String name();
    String phoneNumber();
}
