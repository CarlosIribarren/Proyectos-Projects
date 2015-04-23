// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.aena.domain;

import com.aena.domain.Empresa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect Empresa_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager Empresa.entityManager;
    
    public static final List<String> Empresa.fieldNames4OrderClauseFilter = java.util.Arrays.asList("");
    
    public static final EntityManager Empresa.entityManager() {
        EntityManager em = new Empresa().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long Empresa.countEmpresas() {
        return entityManager().createQuery("SELECT COUNT(o) FROM Empresa o", Long.class).getSingleResult();
    }
    
    public static List<Empresa> Empresa.findAllEmpresas() {
        return entityManager().createQuery("SELECT o FROM Empresa o", Empresa.class).getResultList();
    }
    
    public static List<Empresa> Empresa.findAllEmpresas(String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Empresa o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Empresa.class).getResultList();
    }
    
    public static Empresa Empresa.findEmpresa(Integer idEmpresa) {
        if (idEmpresa == null) return null;
        return entityManager().find(Empresa.class, idEmpresa);
    }
    
    public static List<Empresa> Empresa.findEmpresaEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM Empresa o", Empresa.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    public static List<Empresa> Empresa.findEmpresaEntries(int firstResult, int maxResults, String sortFieldName, String sortOrder) {
        String jpaQuery = "SELECT o FROM Empresa o";
        if (fieldNames4OrderClauseFilter.contains(sortFieldName)) {
            jpaQuery = jpaQuery + " ORDER BY " + sortFieldName;
            if ("ASC".equalsIgnoreCase(sortOrder) || "DESC".equalsIgnoreCase(sortOrder)) {
                jpaQuery = jpaQuery + " " + sortOrder;
            }
        }
        return entityManager().createQuery(jpaQuery, Empresa.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void Empresa.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void Empresa.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            Empresa attached = Empresa.findEmpresa(this.idEmpresa);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void Empresa.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void Empresa.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public Empresa Empresa.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        Empresa merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}