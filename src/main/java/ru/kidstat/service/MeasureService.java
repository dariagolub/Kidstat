package ru.kidstat.service;

import ru.kidstat.model.Measure;

import java.util.List;

/**
 * Created by darya on 09/04/15.
 */

public interface MeasureService {
    Measure save(Measure measure);
    List<Measure> getMeasures();
}
