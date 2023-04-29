package com.qacollaboration.utils.db;

import java.util.List;
import java.util.Map;

public interface DataBaseUtil {
    List<Map<String,?>> select(String query);
}
