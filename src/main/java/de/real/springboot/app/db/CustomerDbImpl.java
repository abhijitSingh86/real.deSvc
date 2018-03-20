package de.real.springboot.app.db;

import de.real.springboot.app.helper.DummyDataHelper;
import de.real.springboot.app.models.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerDbImpl  implements CustomerDb{
    @Override
    public Optional<Customer> getCustomer(Integer id) {
        List<Customer> l = DummyDataHelper.customers.stream().filter(x->x.getId() == id).collect(Collectors.toList());
        if(l.size() >0){
            return Optional.of(l.get(0));
        }
        return Optional.empty();
    }
}
