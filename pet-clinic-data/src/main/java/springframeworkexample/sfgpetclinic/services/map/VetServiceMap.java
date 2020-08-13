package springframeworkexample.sfgpetclinic.services.map;

import org.springframework.stereotype.Service;
import springframeworkexample.sfgpetclinic.model.Speciality;
import springframeworkexample.sfgpetclinic.model.Vet;
import springframeworkexample.sfgpetclinic.services.SpecialityService;
import springframeworkexample.sfgpetclinic.services.VetService;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialityService specialityService;

    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findByID(id);
    }

    @Override
    public Vet save(Vet object) {
        if(object != null){
            if(object.getSpeciality().size() > 0){
                object.getSpeciality().forEach(speciality -> {
                    if(speciality.getId() == null){
                        Speciality savedSpeciality = specialityService.save(speciality);
                        speciality.setId(savedSpeciality.getId());
                    }
                });
            }
            return super.save(object);
        }else{
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

}
