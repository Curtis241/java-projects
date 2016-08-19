package ca.pragmaticdev.ws.data.mapper;

import ca.pragmaticdev.ws.data.DailyIntakeImpl;
import java.util.List;

public interface DailyIntakeMapper {

        List<DailyIntakeImpl> SelectAll();

        List<DailyIntakeImpl> SelectById(int dailyIntakeId);

        List<DailyIntakeImpl> SelectByUserId(long userId);

        void Delete(int dailyIntakeId);

        void Insert(DailyIntakeImpl dailyIntake);

        void Remove(int dailyIntakeId);

        void Update(DailyIntakeImpl dailyIntake);

        int SelectNextId();
}
