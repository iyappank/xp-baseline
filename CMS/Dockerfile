# escape=`
# Use Sitecore base image for Headless CD role
FROM sitecore-xp-jss-headless-cd:10.3-ltsc2019

# Set working directory
WORKDIR C:\inetpub\wwwroot

# Copy custom code / configuration (if any)
# Example: include your JSS app build output
COPY .\deploy\ /inetpub/wwwroot/

# Expose IIS port
EXPOSE 80

# Environment variables
ENV SITECORE_ROLE=cd `
    SITECORE_JSS_ENABLED=true `
    SITECORE_LICENSE=C:\license\license.xml

# Health check
HEALTHCHECK --interval=30s --timeout=30s --start-period=60s --retries=3 `
  CMD powershell -command `
    try { `
      $response = Invoke-WebRequest http://localhost/healthz -UseBasicParsing; `
      if ($response.StatusCode -eq 200) { exit 0 } else { exit 1 } `
    } catch { exit 1 }

# Default entrypoint provided by Sitecore base image (IIS)