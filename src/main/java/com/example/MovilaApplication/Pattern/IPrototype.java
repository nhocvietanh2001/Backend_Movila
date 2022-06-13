package com.example.MovilaApplication.Pattern;

import com.example.MovilaApplication.Models.Account;

public interface IPrototype {
    public Account cloneAndRemovePassword();
}
