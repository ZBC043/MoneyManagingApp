package me.csed2.moneymanager.rest.monzo.client;

import lombok.Getter;
import lombok.Setter;
import me.csed2.moneymanager.rest.BankClient;
import me.csed2.moneymanager.utils.StateGenerator;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class MonzoHttpClient extends BankClient<MonzoAccount> {

    private String state;

    @Getter @Setter
    private static MonzoAccount selectedAccount;

    public MonzoHttpClient() {

    }

    @Override
    public void accessPage() throws URISyntaxException, IOException {
        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().browse(buildURI());
        }
    }

    @Override
    protected URI buildURI() throws URISyntaxException {
        StringBuilder builder = new StringBuilder("https://auth.monzo.com/?");
        state = StateGenerator.generate();

        builder.append("client_id=").append(MonzoDetails.CLIENT_ID).append("&");
        builder.append("redirect_uri=").append(MonzoDetails.REDIRECT_URI).append("&");
        builder.append("response_type=code").append("&");
        builder.append("state=").append(state);

        return new URI(builder.toString());
    }
}
