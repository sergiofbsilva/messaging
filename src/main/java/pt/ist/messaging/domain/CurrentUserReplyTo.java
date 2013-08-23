/*
 * @(#)CurrentUserReplyTo.java
 *
 * Copyright 2012 Instituto Superior Tecnico
 * Founding Authors: Luis Cruz
 * 
 *      https://fenix-ashes.ist.utl.pt/
 * 
 *   This file is part of the Messaging Module.
 *
 *   The Messaging Module is free software: you can
 *   redistribute it and/or modify it under the terms of the GNU Lesser General
 *   Public License as published by the Free Software Foundation, either version 
 *   3 of the License, or (at your option) any later version.
 *
 *   The Messaging Module is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *   GNU Lesser General Public License for more details.
 *
 *   You should have received a copy of the GNU Lesser General Public License
 *   along with the Messaging Module. If not, see <http://www.gnu.org/licenses/>.
 * 
 */
package pt.ist.messaging.domain;

import pt.ist.bennu.core.domain.User;
import pt.ist.bennu.core.security.Authenticate;

/**
 * 
 * @author Luis Cruz
 * 
 */
public class CurrentUserReplyTo extends CurrentUserReplyTo_Base {

    public CurrentUserReplyTo() {
        super();
    }

    @Override
    public String getReplyToAddress(final User user) {
        return user == null ? getReplyToAddress() : user.getEmail();
    }

    @Override
    public String getReplyToAddress() {
        final User user = Authenticate.getUser();
        return user == null ? null : user.getEmail();
    }

}
