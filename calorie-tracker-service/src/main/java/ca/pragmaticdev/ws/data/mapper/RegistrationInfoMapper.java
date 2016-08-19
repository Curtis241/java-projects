package ca.pragmaticdev.ws.data.mapper;

import ca.pragmaticdev.ws.data.RegistrationInfo;

import java.util.List;

public interface RegistrationInfoMapper {
    
        List<RegistrationInfo> SelectAll();

        RegistrationInfo SelectById(int userId);

        void Delete(int userId);

        void Insert(RegistrationInfo registrationInfo);

        void Remove(int userId);

        void Update(RegistrationInfo registrationInfo);

        int SelectNextId();

        int SelectCurrentId();
}
