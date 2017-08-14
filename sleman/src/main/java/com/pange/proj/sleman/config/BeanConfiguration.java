package com.pange.proj.sleman.config;

import org.jasypt.digest.StandardStringDigester;
import org.jasypt.digest.config.SimpleStringDigesterConfig;
import org.jasypt.salt.FixedStringSaltGenerator;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
  
  private static final String HEXADECIMAL = "HEXA";
  
  @Value("${digester.salt}")
  public String salt;

  @Value("${digester.algorithm}")
  public String algorithm;

  @Value("${digester.iteration}")
  public String iteration;

  @Value("${digester.saltSizeBytes}")
  public String saltSizeBytes;

  @Bean
  public StandardStringDigester jasyptDigester() {
    FixedStringSaltGenerator saltGenerator = new FixedStringSaltGenerator();
    saltGenerator.setSalt(salt);

    SimpleStringDigesterConfig digesterConfig = new SimpleStringDigesterConfig();
    digesterConfig.setAlgorithm(algorithm);
    digesterConfig.setIterations(iteration);
    digesterConfig.setSaltGenerator(saltGenerator);
    digesterConfig.setSaltSizeBytes(saltSizeBytes);

    StandardStringDigester jasyptDigester = new StandardStringDigester();
    jasyptDigester.setConfig(digesterConfig);
    jasyptDigester.setStringOutputType(HEXADECIMAL);

    return jasyptDigester;
  }

  @Bean
  public ModelMapper getModelMapper() {
    ModelMapper modelMapper =  new ModelMapper();
    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    return modelMapper;
  }
}
