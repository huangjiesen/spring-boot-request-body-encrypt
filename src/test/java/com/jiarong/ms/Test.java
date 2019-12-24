package com.jiarong.ms;

import com.ofwiki.encrypt.utils.AesUtil;

/**
 * Created by sen on 18-8-31.
 */
public class Test {
    public static void main(String[] args) throws NoSuchMethodException {
        String text = "{\n" +
                "  \"id\": \"271306109980385280\"" +
                "}";
        System.out.println(AesUtil.encrypt(text, "2222222222222222","1111111111111111"));

        System.out.println(AesUtil.decrypt("MQBdG6XSqWALBaOnGs4VILUWPMHReupLVwij55HT+42C0K0ZfVo1ANa2eB1Ld5ny1qfkVYOMHF0D6AFDO62Qsa5ff6cN+LddDMhlahCMculec4A3tvadjJQnLdAa+y3/AiBw2RvMem7HXgP6j/x7JXxn82Q/SewUKmL4P0qjUIW7/Q1MuzliA3FCE762ILW9mZdi0vglC63vherMad1tW7BVyiAXbWUS7DDa+2QUydEe0Vfs/ficv9HkdGscKvK0QTOxRWEijyxkvLgyWB/VOLtXzBCJNDBHBA+OZphiLnAbyAPa+GMwmRQDfUt7YCwEOwGv6bnfzTcme6S30IPmq4DBUxM4TtpSulxCRuwivUia7sm8IxSsE78o2Ap2TNu5cZRQsiVoNerWI1NTyFJz4p7iXndtkHpJpErUlYF9tyAnhe89Hjcyug8+1XFg8yFMeR/UOMAxyhs1M8lqQCuHzoXhxq0L/ruLiNKP7JT0fsjoe7TqkpzJ64E6DAS58aZToMcqb18IyjLXYxTZTN8Jlvp4hCP9DyvSIbtu2FARdb31XS2ZAuttF6S8PaWIA+yZLJr/3zH20CWgt35D56CTeya3qScovWp3f6v+tJj1BGgTC1z1LcSotGRg5TK3CV2J1penu3gbWpWqDeM5PfGvfK79tVkwNrmws1Y7wrkgydY+aU89OEHehdGSRfmJBePlUNS2YAChHqRBFsDOahdozq48SHjdl7Z4PEzKGHD2rmSuaAIXLLDcMV69MPrVDbUTTo+n+PwAw75No3hk8iJt79iR/VzbKUA3scT/Ut28KfMzr92ZnN/5I9BzF8XiwkEaEAYimBayTI8TsgQbMj+x9+swdFfqXIGBIFjNCxEUyD6e742Z8qGE+3r9GNktKAVtupWOu2O6a6awOFI5AZ5ljtAOUUnWwr4OcuDM610c36k=", "2222222222222222","1111111111111111"));
    }
}
