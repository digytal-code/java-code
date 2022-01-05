package code.jpa.audit.infra;

import javax.persistence.EntityManagerFactory;

import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.javers.core.Javers;
import org.javers.core.JaversBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.teastman.hibernate.AnnotatedHibernateEventListenerInvoker;

@Configuration
class AuditConfig {
	
    @Autowired
	private EntityManagerFactory entityManagerFactory;
    
    @Bean
    public AnnotatedHibernateEventListenerInvoker annotatedHibernateEventHandlerInvoker() {
        AnnotatedHibernateEventListenerInvoker invoker = new AnnotatedHibernateEventListenerInvoker();
        SessionFactoryImplementor sessionFactory = entityManagerFactory.unwrap(SessionFactoryImplementor.class);
        EventListenerRegistry registry = sessionFactory.getServiceRegistry().getService(EventListenerRegistry.class);

        registry.prependListeners(EventType.PRE_UPDATE, invoker);
        registry.prependListeners(EventType.PRE_DELETE, invoker);
        registry.prependListeners(EventType.PRE_INSERT, invoker);
        
        return invoker;
    }

    @Bean
    public Javers javers() {
    	return JaversBuilder.javers().build();
    }
}