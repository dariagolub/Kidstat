package ru.kidstat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kidstat.dao.MeasureDAO;
import ru.kidstat.model.Measure;

/**
 * Created by darya on 09/04/15.
 */

@Service("measureService")
public class MeasureServiceImpl implements MeasureService{
    @Autowired
    private MeasureDAO measureDAO;

    @Override
    @Transactional
    public Measure save(Measure measure) {
        return measureDAO.save(measure);
    }
}
