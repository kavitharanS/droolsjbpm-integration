/*
 * Copyright 2010 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kie.server.api.commands;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.kie.server.api.model.KieServerCommand;

@XmlRootElement(name = "script")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "script", propOrder = {"lookup", "commands"})
public class CommandScript implements Serializable {

    private static final long serialVersionUID = 510l;

    @XmlAttribute
    private String            lookup;

    @XmlElements({
        @XmlElement(name = "create-container", type = CreateContainerCommand.class),
        @XmlElement(name = "list-containers", type = ListContainersCommand.class),
        @XmlElement(name = "dispose-container", type = DisposeContainerCommand.class),
        @XmlElement(name = "call-container", type = CallContainerCommand.class)
    })
    protected List<KieServerCommand> commands;

    public CommandScript() {
    }

    public CommandScript(List<KieServerCommand> commands) {
        this.commands = commands;
    }

    public CommandScript(List<KieServerCommand> commands, String lookup) {
        this.commands = commands;
        this.lookup = lookup;
    }

    public List<KieServerCommand> getCommands() {
        if (commands == null) {
            commands = new ArrayList<KieServerCommand>();
        }
        return this.commands;
    }

    public void setLookup(String lookup) {
        this.lookup = lookup;
    }

    public String getLookup() {
        return lookup;
    }

    public String toString() {
        return "CommandScriptImpl{" +
                "lookup='" + lookup + '\'' +
                ", commands=" + commands +
                '}';
    }
}