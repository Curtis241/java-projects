package ca.pragmaticdev.ws.data.mapper;

import ca.pragmaticdev.ws.data.DailyIntake;
import java.util.List;

public interface DailyIntakeMapper {

        List<DailyIntake> SelectAll();

        List<DailyIntake> SelectById(int dailyIntakeId);

        List<DailyIntake> SelectByUserId(int userId);

        List<DailyIntake> SelectByDate(String date);

        void Delete(int dailyIntakeId);

        void Insert(DailyIntake dailyIntake);

        void Remove(int dailyIntakeId);

        void Update(DailyIntake dailyIntake);

        int SelectNextId();

        int SelectCurrentId();
}
