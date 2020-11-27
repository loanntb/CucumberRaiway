package stepConfig;

import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableEntryTransformer;
import stepObjects.Register;

import java.util.Locale;
import java.util.Map;

public class DataTableConfig implements TypeRegistryConfigurer {
    @Override
    public void configureTypeRegistry(TypeRegistry registry) {
        registry.defineDataTableType(new DataTableType(Register.class, new TableEntryTransformer<Register>() {
            @Override
            public Register transform(Map<String, String> entry) {
                return new Register(entry.get("email"), entry.get("password"), entry.get("confirmPassword"), entry.get("pid"));
            }
        }));
    }

    @Override
    public Locale locale() {
        return Locale.ENGLISH;
    }

}
