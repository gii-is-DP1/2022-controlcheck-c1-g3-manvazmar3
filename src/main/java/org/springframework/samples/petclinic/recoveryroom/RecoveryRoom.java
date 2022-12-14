package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Recovery")
public class RecoveryRoom extends BaseEntity{
    @NotEmpty
    @Size(min=3, max=50)
    private String name;
    @NotEmpty
    @PositiveOrZero
    private double size;
    @NotNull
    private boolean secure;
    @ManyToOne
    @JoinColumn(name="type")
    RecoveryRoomType roomType;
}
