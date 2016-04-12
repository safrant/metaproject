package edu.stanford.protege.metaproject.impl;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.metaproject.api.*;

import javax.annotation.Nonnull;
import java.io.Serializable;
import java.util.Set;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author Rafael Gonçalves <br>
 * Stanford Center for Biomedical Informatics Research
 */
public final class RoleImpl implements Role, Serializable {
    private static final long serialVersionUID = -220401317372110321L;
    private final RoleId id;
    private final Name name;
    private final Description description;
    private final ImmutableSet<OperationId> operations;

    /**
     * Constructor
     *
     * @param id    Role identifier
     * @param name  Role name
     * @param description   Role description
     * @param operations    Set of operations that can be performed on the given projects
     */
    public RoleImpl(RoleId id, Name name, Description description, Set<OperationId> operations) {
        this.id = checkNotNull(id);
        this.name = checkNotNull(name);
        this.description = checkNotNull(description);

        ImmutableSet<OperationId> operationsCopy = new ImmutableSet.Builder<OperationId>().addAll(checkNotNull(operations)).build();
        this.operations = checkNotNull(operationsCopy);
    }

    @Override
    public RoleId getId() {
        return id;
    }

    @Override
    public Name getName() {
        return name;
    }

    @Override
    public Description getDescription() {
        return description;
    }

    @Override
    public Set<OperationId> getOperations() {
        return operations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleImpl role = (RoleImpl) o;
        return Objects.equal(id, role.id) &&
                Objects.equal(name, role.name) &&
                Objects.equal(description, role.description) &&
                Objects.equal(operations, role.operations);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, description, operations);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .add("description", description)
                .add("operations", operations)
                .toString();
    }

    @Override
    public int compareTo(@Nonnull Role that) {
        return ComparisonChain.start()
                .compare(this.name.get(), that.getName().get())
                .result();
    }
}
