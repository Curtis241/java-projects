package ca.pragmaticdev.ws.data.mapper;

import ca.pragmaticdev.ws.data.Serving;
import ca.pragmaticdev.ws.data.ServingImpl;

import java.util.List;

public interface ServingMapper {

    List<Serving> SelectAll();

    List<Serving> SelectByDailyIntakeId(int dailyIntakeId);

    void Delete(int dailyIntakeId);

    void Insert(Serving serving);

    void Remove(int dailyIntakeId);

    void Update(Serving serving);

    int SelectNextId();

    int SelectCurrentId();
}
