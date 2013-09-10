/*
 * Copyright (C) 2013 Dabo Ross <http://www.daboross.net/>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.daboross.minecrafttesting.commands;

import net.daboross.minecrafttesting.command.Command;
import net.daboross.minecrafttesting.command.Sender;
import net.theunnameddude.mcclient.api.MinecraftClient;
import net.theunnameddude.mcclient.api.MinecraftClientConnector;
import net.theunnameddude.mcclient.api.auth.AuthenticationResponse;
import net.theunnameddude.mcclient.api.auth.Authenticator;

/**
 *
 * @author Dabo Ross <http://www.daboross.net/>
 */
public class SetUsernamePassword extends Command {

    public SetUsernamePassword() {
        super("connect");
        setHelpText("Connect to a server");
        setHelpArgs("Server", "Port", "Username", "Password");
    }

    @Override
    public void run(Sender sender, String commandLabel, String[] args) {
        if (args.length < 4) {
            sendHelpText(sender);
        }
        String server = args[0];
        String port = args[1];
        String username = args[2];
        String password = args[3];
        AuthenticationResponse auth = Authenticator.sendRequest(username, password);
        MinecraftClient client = MinecraftClientConnector.connect(server, 25565, auth);
    }
}