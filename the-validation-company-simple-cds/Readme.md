## Report results

| Property                             | Java Application | Spring Application |
|--------------------------------------|------------------|--------------------|
| Startup wo/CDS (ms)                  | 23.11            | ?                  |
| Startup wo/CDS unpacked (ms)         | NA               | ?                  |
| Startup w/CDS (ms)                   | 29.27            | ?                  |
| Startup w/CDS + AOT (ms)             | NA               | ?                  |
| Committed memory wo/CDS              | 12.952           | ?                  |
| Committed memory wo/CDS unpacked(Mb) | NA               | ?                  |
| Committed memory w/CDS (Mb)          | 8.080            | ?                  |
| Committed memory w/CDS + AOT (Mb)    | NA               | ?                  |
| Total classes wo/CDS                 | 815              | ?                  |
| Total classes wo/CDS unpacked        | NA               | ?                  |
| Total classes w/CDS                  | 818              | ?                  |
| Total classes w/CDS + AOT            | NA               | ?                  |

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

- [Java's Startup Booster: CDS @ Java by Stack Walker](https://www.youtube.com/watch?v=vvlQv1Dh-HU)

### Online Document

- [AppCDS Autogenerate - Sip of Java](https://inside.java/2022/09/26/sip067/)
- [CDS and AppCDS in Hotspot](https://dev.java/learn/jvm/cds-appcds/)