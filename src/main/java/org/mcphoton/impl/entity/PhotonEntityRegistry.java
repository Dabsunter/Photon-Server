/*
 * Copyright (c) 2016 MCPhoton <http://mcphoton.org> and contributors.
 *
 * This file is part of the Photon Server Implementation <https://github.com/mcphoton/Photon-Server>.
 *
 * The Photon Server Implementation is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Photon Server Implementation is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.mcphoton.impl.entity;

import com.electronwill.utils.IndexMap;
import java.util.HashMap;
import java.util.Map;
import org.mcphoton.entity.EntityRegistry;
import org.mcphoton.entity.EntityType;

/**
 *
 * @author TheElectronWill
 */
public class PhotonEntityRegistry implements EntityRegistry {

	private final IndexMap<EntityType> idMap = new IndexMap<>();
	private final Map<String, EntityType> nameMap = new HashMap<>();

	@Override
	public synchronized void register(EntityType type) {
		int id = idMap.size();
		type.initializeId(id);
		idMap.put(id, type);
		nameMap.put(type.getUniqueName(), type);
	}

	@Override
	public synchronized void register(EntityType type, int id) {
		type.initializeId(id);
		idMap.put(id, type);
		nameMap.put(type.getUniqueName(), type);
	}

	@Override
	public synchronized EntityType getRegistered(int id) {
		return idMap.get(id);
	}

	@Override
	public synchronized EntityType getRegistered(String name) {
		return nameMap.get(name);
	}

	@Override
	public synchronized boolean isRegistered(int id) {
		return idMap.containsKey(id);
	}

	@Override
	public synchronized boolean isRegistered(String name) {
		return nameMap.containsKey(name);
	}

}
