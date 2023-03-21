FROM mcr.microsoft.com/mssql/server

COPY ./data /

ENV MSSQL_SA_PASSWORD: "p@ssword123456789!"

ENTRYPOINT [ "/bin/bash", "entrypoint.sh" ]
CMD [ "/opt/mssql/bin/sqlservr" ]