## JLink

To better perform test with JLink and compare differences, make sure that your local runtime, matche the one of the docker images. Ideally, this project should be tested using Temurin images:

```shell
sdk install java 21.0.5-tem
```

## CDS Report results

| Property                             | Java Application | Spring Application |
|--------------------------------------|------------------|--------------------|
| Startup wo/CDS (ms)                  | 23.11            | 930                |
| Startup wo/CDS unpacked (ms)         | NA               | 808                |
| Startup w/CDS (ms)                   | 29.27            | 430                |
| Startup w/CDS + AOT (ms)             | NA               | 297                |
| Committed memory wo/CDS              | 12.952           | 12.952             |
| Committed memory wo/CDS unpacked(Mb) | NA               | 12.952             |
| Committed memory w/CDS (Mb)          | 8.080            | 55.640             |
| Committed memory w/CDS + AOT (Mb)    | NA               | 53.880             |
| Total classes wo/CDS                 | 815              | 9209               |
| Total classes wo/CDS unpacked        | NA               | 9096               |
| Total classes w/CDS                  | 818              | 8975               |
| Total classes w/CDS + AOT            | NA               | 8704               |

## How to run

```shell
make cds-class-list
make cds-archive
make cds-launch
make cds-launch-logs
make cds-verify-class-loading
make cds-verify-cds-logs
make cds-verify-class-loaders
make cds-verify-native-memory
make cds-verify-issued-commands
make cds-verify-system-properties
```

## Resources

### Online Videos

-   [Java's Startup Booster: CDS @ Java by Stack Walker](https://www.youtube.com/watch?v=vvlQv1Dh-HU)

### Online Document

-   [AppCDS Autogenerate - Sip of Java](https://inside.java/2022/09/26/sip067/)
-   [CDS and AppCDS in Hotspot](https://dev.java/learn/jvm/cds-appcds/)

## About me

[![GitHub followers](https://img.shields.io/github/followers/jesperancinha.svg?label=Jesperancinha&style=for-the-badge&logo=github&color=grey "GitHub")](https://github.com/jesperancinha)
