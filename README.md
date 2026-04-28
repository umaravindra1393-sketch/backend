# Learnx Spring Boot Backend

This is the Spring Boot backend for Learnx. It mirrors the existing `/api` endpoints and uses the same default MySQL settings as the previous backend.

## Run

```powershell
.\mvnw.cmd spring-boot:run
```

From the project root, you can also run:

```powershell
npm run dev:backend
```

## Configuration

Configuration is read from environment variables:

- `PORT` defaults to `8080`
- `FRONTEND_URL` defaults to `http://localhost:5173`
- `DB_HOST`, `DB_PORT`, `DB_USER`, `DB_PASSWORD`, and `DB_NAME`
- `JWT_SECRET`
- `MAIN_ADMIN_EMAIL`, `MAIN_ADMIN_PASSWORD`, and `MAIN_ADMIN_NAME`
- `OTP_SMTP_HOST`, `OTP_SMTP_PORT`, `OTP_SMTP_USER`, `OTP_SMTP_PASS`, and `OTP_MAIL_FROM`
- `UPLOAD_DIR` defaults to `../backend/uploads` so existing resource files remain available

The Spring Boot app also loads `.env` values from the project root and the existing `backend/.env`, so your current database and OTP SMTP settings can be reused without editing the old backend files.

## Hosted Deployment

### Render

This repo now includes a [render.yaml](D:/Zyndex/spring-backend/render.yaml) and [Dockerfile](D:/Zyndex/spring-backend/Dockerfile) for Render.

1. In Render, create a new `Blueprint` or `Web Service` from this repo.
2. If you use the blueprint, Render reads `render.yaml` automatically.
3. Set these environment variables in Render:
   - `FRONTEND_URL` to your deployed frontend URL
   - `DB_HOST`, `DB_PORT`, `DB_NAME`, `DB_USER`, `DB_PASSWORD`
   - `JWT_SECRET`
4. Keep `PORT=10000` unless you have a specific reason to change it.

Notes:
- This backend expects a hosted MySQL-compatible database. Do not use your local laptop MySQL for Render.
- `UPLOAD_DIR` is set to `/tmp/learnx-uploads` by default for Render. That storage is ephemeral, so uploaded files are not permanent unless you later move them to persistent storage.

