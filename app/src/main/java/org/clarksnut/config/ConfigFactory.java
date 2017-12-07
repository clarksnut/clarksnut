package org.clarksnut.config;

import org.wildfly.swarm.spi.runtime.annotations.ConfigurationValue;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;

@Dependent
public class ConfigFactory {

    @Produces
    public FileTruststoreConfig produceFileTruststoreConfig(@ConfigurationValue("clarksnut.truststore.file.file") String file,
                                                            @ConfigurationValue("clarksnut.truststore.file.password") String password,
                                                            @ConfigurationValue("clarksnut.truststore.file.hostname-verification-policy") String hostnameVerificationPolicy,
                                                            @ConfigurationValue("clarksnut.truststore.file.disabled") Boolean disabled) {
        return FileTruststoreConfig.builder()
                .file(file)
                .password(password)
                .hostnameVerificationPolicy(hostnameVerificationPolicy)
                .disabled(disabled)
                .build();
    }

    @Produces
    public GmailClientConfig produceGmailClientConfig(@ConfigurationValue("clarksnut.mail.vendor.gmail.applicationName") String applicationName) {
        return GmailClientConfig.builder().applicationName(applicationName).build();
    }

    @Produces
    public ReportThemeConfig produceReportThemeConfig(@ConfigurationValue("clarksnut.report.default") String defaultTheme,
                                                      @ConfigurationValue("clarksnut.report.cacheTemplates") Boolean cacheTemplates,
                                                      @ConfigurationValue("clarksnut.report.cacheReports") Boolean cacheReports,
                                                      @ConfigurationValue("clarksnut.report.folder.dir") String folderDir) {
        return ReportThemeConfig.builder()
                .defaultTheme(defaultTheme)
                .cacheTemplates(cacheTemplates)
                .cacheReports(cacheReports)
                .folderDir(folderDir)
                .build();
    }


    @Produces
    public ThemeConfig produceThemeConfig(@ConfigurationValue("clarksnut.theme.default") String defaultTheme,
                                          @ConfigurationValue("clarksnut.theme.staticMaxAge") Long staticMaxAge,
                                          @ConfigurationValue("clarksnut.theme.cacheTemplates") Boolean cacheTemplates,
                                          @ConfigurationValue("clarksnut.theme.cacheThemes") Boolean cacheThemes,
                                          @ConfigurationValue("clarksnut.theme.folder.dir") String folderDir) {
        return ThemeConfig.builder()
                .defaultTheme(defaultTheme)
                .staticMaxAge(staticMaxAge)
                .cacheTemplates(cacheTemplates)
                .cacheThemes(cacheThemes)
                .folderDir(folderDir)
                .build();
    }

    @Produces
    public SmtpConfig produceSmtpConfig(@ConfigurationValue("clarksnut.mail.smtp.host") String host,
                                        @ConfigurationValue("clarksnut.mail.smtp.port") String port,
                                        @ConfigurationValue("clarksnut.mail.smtp.from") String from,
                                        @ConfigurationValue("clarksnut.mail.smtp.fromDisplayName") String fromDisplayName,
                                        @ConfigurationValue("clarksnut.mail.smtp.replyTo") String replyTo,
                                        @ConfigurationValue("clarksnut.mail.smtp.replyToDisplayName") String replyToDisplayName,
                                        @ConfigurationValue("clarksnut.mail.smtp.envelopeFrom") String envelopeFrom,
                                        @ConfigurationValue("clarksnut.mail.smtp.ssl") Boolean ssl,
                                        @ConfigurationValue("clarksnut.mail.smtp.starttls") Boolean starttls,
                                        @ConfigurationValue("clarksnut.mail.smtp.auth") Boolean auth,
                                        @ConfigurationValue("clarksnut.mail.smtp.user") String user,
                                        @ConfigurationValue("clarksnut.mail.smtp.password") String password) {
        return SmtpConfig.builder()
                .host(host)
                .port(port)
                .from(from)
                .fromDisplayName(fromDisplayName)
                .replayTo(replyTo)
                .replayToDisplayName(replyToDisplayName)
                .envelopeFrom(envelopeFrom)
                .ssl(ssl)
                .starttls(starttls)
                .auth(auth)
                .user(user)
                .user(password)
                .build();
    }

}
