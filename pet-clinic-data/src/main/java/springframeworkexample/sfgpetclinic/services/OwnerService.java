package springframeworkexample.sfgpetclinic.services;

import springframeworkexample.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
    Owner findByLastName(String lastName);

}
