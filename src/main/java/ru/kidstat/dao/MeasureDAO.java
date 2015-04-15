package ru.kidstat.dao;

import ru.kidstat.model.Measure;

import java.util.List;

/**
 * Created by darya on 09/04/15.
 */
public interface MeasureDAO {

    Measure save(Measure measure);
    List<Measure> getMeasures();
}
