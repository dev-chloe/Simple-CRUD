FROM node:12-alpine AS BUILD_LAYER

ENV WEB_DIR /app
COPY . $WEB_DIR/.
WORKDIR $WEB_DIR

RUN npm install
RUN npm run build

EXPOSE 3000

ENTRYPOINT ["npm", "run", "start"]
