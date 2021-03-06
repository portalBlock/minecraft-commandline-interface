/*
 * Copyright (C) 2013-2014 Dabo Ross <http://www.daboross.net/>
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
package net.daboross.mccli.input;

import java.util.logging.Level;
import java.util.logging.Logger;
import net.daboross.mccli.command.Sender;

public class ConsoleCommandSender implements Sender {

    private final Logger logger;

    public ConsoleCommandSender(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void sendMessage(String message) {
        sendMessage(Level.INFO, message);
    }

    @Override
    public void sendMessage(Level level, String message) {
        if (level == null) {
            level = Level.INFO;
        }
        logger.log(level, message);
    }
}
