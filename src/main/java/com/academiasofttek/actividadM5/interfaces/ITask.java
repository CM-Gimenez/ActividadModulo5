
package com.academiasofttek.actividadM5.interfaces;

import com.academiasofttek.actividadM5.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Carlos Martin Gimenez
 */
public interface ITask extends JpaRepository<Task, Integer>{
    
}
