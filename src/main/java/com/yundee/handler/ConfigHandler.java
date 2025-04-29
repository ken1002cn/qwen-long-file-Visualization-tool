package com.yundee.handler;

import com.google.gson.Gson;
import com.yundee.domain.UserConfig;
import lombok.extern.slf4j.Slf4j;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

@Slf4j
public class ConfigHandler {
    private static final String CONFIG_FILENAME = "config.json";
    private static final File CONFIG_FILE = new File(CONFIG_FILENAME);
    private static final Gson gson = new Gson();

    public static UserConfig loadConfig() {
        try {
            if (!CONFIG_FILE.exists()) {
                // 第一次运行，从 resources 中复制出来
                InputStream in = ConfigHandler.class.getClassLoader().getResourceAsStream(CONFIG_FILENAME);
                if (in == null) throw new FileNotFoundException("未找到默认配置文件资源！");
                Files.copy(in, CONFIG_FILE.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }

            try (Reader reader = new FileReader(CONFIG_FILE)) {
                return gson.fromJson(reader, UserConfig.class);
            }
        } catch (IOException e) {
            log.error(e.getMessage());
            return new UserConfig(); // 出错时用默认配置
        }
    }

    public static void saveConfig(UserConfig config) {
        try (Writer writer = new FileWriter(CONFIG_FILE)) {
            gson.toJson(config, writer);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
