package com.student_tracking_system.student.tracking.system.common;

import java.io.Serial;

public class GeneralException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = 1L;

    public GeneralException(String message) {
        super(message);
    }
}
