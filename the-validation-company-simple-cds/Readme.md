## Report results

| Property                     | Java Application | Spring Application |
|------------------------------|------------------|--------------------|
| Startup w/CDS (ms)           | ?                | ?                  |
| Startup wo/CDS (ms)          | ?                | ?                  |
| Committed memory wo/CDS (ms) | ?                | ?                  |
| Committed memory w/CDS (ms)  | ?                | ?                  |

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