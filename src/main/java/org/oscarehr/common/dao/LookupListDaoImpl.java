//CHECKSTYLE:OFF
/**
 * Copyright (c) 2024. Magenta Health. All Rights Reserved.
 * Copyright (c) 2001-2002. Department of Family Medicine, McMaster University. All Rights Reserved.
 * This software is published under the GPL GNU General Public License.
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 * <p>
 * This software was written for the
 * Department of Family Medicine
 * McMaster University
 * Hamilton
 * Ontario, Canada
 * <p>
 * Modifications made by Magenta Health in 2024.
 */
package org.oscarehr.common.dao;

import java.util.List;

import javax.persistence.Query;

import org.oscarehr.common.model.LookupList;
import org.springframework.stereotype.Repository;

@Repository
public class LookupListDaoImpl extends AbstractDaoImpl<LookupList> implements LookupListDao {

    public LookupListDaoImpl() {
        super(LookupList.class);
    }

    @Override
    public List<LookupList> findAllActive() {
        Query q = entityManager.createQuery("select l from LookupList l where l.active=? order by l.name asc");
        q.setParameter(0, true);

        @SuppressWarnings("unchecked")
        List<LookupList> result = q.getResultList();

        return result;
    }

    @Override
    public LookupList findByName(String name) {
        Query q = entityManager.createQuery("select l from LookupList l where l.name=?");
        q.setParameter(0, name);

        LookupList ll = this.getSingleResultOrNull(q);

        return ll;
    }
}
