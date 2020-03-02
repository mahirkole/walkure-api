package com.mahirkole.walkure.aspect;

/*
@Aspect
@Component
public class MapperAspectAdvice extends CoreAspect {

    private final MapperService mapperService;

    @Autowired
    public MapperAspectAdvice(MapperService mapperService) {
        this.mapperService = mapperService;
    }

    @Around(
            "execution(* com.mahirkole.walkure.controller.*.*(..)) && beanAnnotatedWithMapperAspect()")
    public ResponseEntity mapEntityToDto(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = methodSignature.getMethod();
        MapperAspect mapperAspect = method.getAnnotation(MapperAspect.class);
        ResponseEntity responseEntity;

        try {
            responseEntity = (ResponseEntity) proceedingJoinPoint.proceed();
        } catch (CoreException ex) {
            return ex.handle();
        }

        boolean isEntityInstanceOfList = false;
        String source;
        String target;

        HttpStatus httpStatus = responseEntity.getStatusCode();

        if (responseEntity.getBody() instanceof CoreModel) {
            CoreModel entity = (CoreModel) responseEntity.getBody();
            source = entity.getClass().getSimpleName();
        } else if (responseEntity.getBody() instanceof List) {
            List<CoreModel> entities = (List<CoreModel>) responseEntity.getBody();
            if (entities.size() > 0) {
                source = entities.get(0).getClass().getSimpleName();
                isEntityInstanceOfList = true;
            } else {
                // return responseEntity;
                return new ResponseEntity(
                        new CoreResponse(responseEntity.getBody()), responseEntity.getStatusCode());
            }
        } else {
            // return responseEntity;
            return new ResponseEntity(
                    new CoreResponse(responseEntity.getBody()), responseEntity.getStatusCode());
        }

        target = source + "Dto";

        if (mapperAspect.source() != void.class && mapperAspect.target() != void.class) {
            source = mapperAspect.source().getSimpleName();
            target = mapperAspect.target().getSimpleName();
        }

        try {
            CoreMapper mapper = mapperService.getMapper(source, target);
            if (isEntityInstanceOfList) {
                return ResponseEntity.status(httpStatus)
                        .body(new CoreResponse(mapper.toDto((List<CoreModel>) responseEntity.getBody())));
            } else {
                CoreModel responseEntityBody = (CoreModel) responseEntity.getBody();
                return ResponseEntity.status(httpStatus)
                        .body(new CoreResponse(mapper.toDto(responseEntityBody)));
            }
        } catch (MapperNotFoundException ex) {
            // return responseEntity;
            return new ResponseEntity(
                    new CoreResponse(responseEntity.getBody()), responseEntity.getStatusCode());
        }
    }
}
*/