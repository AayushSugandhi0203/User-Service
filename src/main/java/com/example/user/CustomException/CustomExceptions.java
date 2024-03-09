package com.example.user.CustomException;

public class CustomExceptions extends RuntimeException{


        // Constructors
        public CustomExceptions() {
            super();
        }

        public CustomExceptions(String message) {
            super(message);
        }

        public CustomExceptions(String message, Throwable cause) {
            super(message, cause);
        }

        public CustomExceptions(Throwable cause) {
            super(cause);
        }
    }


