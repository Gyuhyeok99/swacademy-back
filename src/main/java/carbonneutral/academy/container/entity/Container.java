package carbonneutral.academy.container.entity;

import carbonneutral.academy.cafe.entity.Cafe;
import carbonneutral.academy.common.BaseEntity;
import carbonneutral.academy.container.entity.enums.ContainerStatus;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Getter
@Builder
@Entity
@Table(name = "container")
public class Container extends BaseEntity {

    @Id
    @Column(name = "container_id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private ContainerStatus containerStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cafe_id")
    private Cafe cafe;
}
